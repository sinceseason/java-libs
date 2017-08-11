package com.xty.common;

import org.apache.log4j.Logger;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class FenceFilter {
    protected final Logger logger = Logger.getLogger(this.getClass());

    private static FenceFilter fenceFilter;

    private HashMap<String, GeneralPath> fenceMap = new HashMap<>();

    public static FenceFilter instance(){
        if(fenceFilter == null)
            fenceFilter = new FenceFilter();
        return fenceFilter;
    }

    public boolean generateFence(String fenceType, Integer fenceId, List<String> pointList){
        try{
            GeneralPath p = new GeneralPath();
            List<Point2D.Double> list = new ArrayList<>();
            for(String str : pointList){
                String[] gpsData = str.split(",");
                Point2D.Double point = new Point2D.Double(Double.parseDouble(gpsData[0]), Double.parseDouble(gpsData[1]));
                list.add(point);
            }

            Point2D.Double first = list.get(0);
            p.moveTo(first.x, first.y);
            for(int i = 1; i < list.size(); i++){
                p.lineTo(list.get(i).x, list.get(i).y);
            }
            p.lineTo(first.x, first.y);
            p.closePath();
            Area a0 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.000,0.000)));
            Area a1 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.005,0.000)));
            Area a2 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.000,0.005)));
            Area a3 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.005,0.005)));
            Area a4 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.005,-0.005)));
            Area b1 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(-0.005,0.000)));
            Area b2 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(0.000,-0.005)));
            Area b3 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(-0.005,-0.005)));
            Area b4 =  new Area(p.createTransformedShape(AffineTransform.getTranslateInstance(-0.005,0.005)));
            a0.add(a1);
            a0.add(a2);
            a0.add(a3);
            a0.add(a4);
            a0.add(b1);
            a0.add(b2);
            a0.add(b3);
            a0.add(b4);
            GeneralPath p1 = new GeneralPath(a0);
//            BufferedImage bi = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
//            Graphics2D g2d = bi.createGraphics();
//            g2d.draw(p1);
//            ImageIO.write(bi, "PNG", new File("E:/Test/1.png"));
            fenceMap.put(fenceType + fenceId, p1);
//            fenceMap.put(fenceType + fenceId+999, p);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
        return false;
    }

    public Point2D.Double convertPointData(String longitude, String latitude){
        try{
            return new Point2D.Double(Double.parseDouble(longitude), Double.parseDouble(latitude));
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
        return null;
    }

    public Point2D.Double convertPointData(double longitude, double latitude){
        try{
            return new Point2D.Double(longitude, latitude);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
        return null;
    }

    public boolean checkOutOfFence(String fenceType, Integer fenceId, String longitude, String latitude){
        try{
            if(fenceMap.containsKey(fenceType + fenceId))
                return fenceMap.get(fenceType + fenceId).contains(convertPointData(longitude, latitude));
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
        return false;
    }

    public boolean checkOutOfFence(String fenceType, Integer fenceId, double longitude, double latitude){
        try{
            if(fenceMap.containsKey(fenceType + fenceId))
                return fenceMap.get(fenceType + fenceId).contains(longitude, latitude);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(ex);
        }
        return false;
    }
}
