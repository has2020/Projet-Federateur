package com.predictionmarketing.itemrecommend;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class scir {

    public static void main(String[] args) {
        try {
            Random rand;
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection conn = DriverManager.getConnection(url, "system", "admin123");
            Statement stmt = conn.createStatement();
            int k=1;
            int j=1;
            for(int i=1;i<10;i++)
            {

                for(j=1;j<72;j++)
                {
                    k++;
                    rand = new Random();
                    int randomnumb = rand.nextInt(5)+1;
                    double num=Double.valueOf(randomnumb);
                    stmt.executeQuery("Insert into RATING(id,IDART1,IDART2,RATING) values("+k+","+ i + "," + j + "," +num + ")");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}