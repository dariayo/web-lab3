package models;

import db.DataBaseManager;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import utils.AreaChecker;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@SessionScoped
@Named
@Model
public class PointsList implements Serializable {
    @Inject
    private PointData pointData;
    private final DataBaseManager dbManager;

    private List<PointData> pointsList;

    public PointsList() {
        pointData = new PointData();
        dbManager = new DataBaseManager();
        pointsList = Collections.synchronizedList(dbManager.loadPoints());
    }


    public synchronized void addPoint() {
        long startTime = System.currentTimeMillis();
        PointData point = new PointData();
        point.setCoordinateX(pointData.getCoordinateX());
        point.setCoordinateY(pointData.getCoordinateY());
        point.setScaleR(pointData.getScaleR());
        point.setIsHit(AreaChecker.check(point.getCoordinateX(), point.getCoordinateY(), point.getScaleR()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        point.setCurrentDate(dateFormat.format(date));
        long endTime = System.nanoTime();
        double totalTime = Math.round(endTime - startTime);
        point.setScriptRunningTime(totalTime);
        pointsList.add(point);
        dbManager.savePoint(point);

    }

    public synchronized List<PointData> getPointsList() {
        return pointsList;
    }

    public String clearList() {
        pointsList = Collections.synchronizedList(new LinkedList<>());
        dbManager.clearPoints();
        return null;
    }

}
