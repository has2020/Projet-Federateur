package com.predictionmarketing.itemrecommend;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class ItemRecommend {

	public static void main(String[] args) {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn = DriverManager.getConnection(url, "system", "admin123");
			Statement stmt = conn.createStatement();
			DataModel dm = new FileDataModel(new File("C:\\Users\\Zepho\\Desktop\\New folder (2)\\stage\\PJF\\src\\main\\java\\data\\abc.csv"));

			TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);

			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);

			int x = 1;
			int i = 0;
			stmt.executeQuery("DELETE FROM RECOMMANDATION");
			for (LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext(); ) {
				long itemId = items.nextLong();
				List<RecommendedItem> recommendations = recommender.mostSimilarItems(itemId, 5);
				for (RecommendedItem recommendation : recommendations) {
					System.out.println(itemId + "," + recommendation.getItemID() + "," + recommendation.getValue());
					i++;
					stmt.executeQuery("Insert into RECOMMANDATION(id,IDART1,IDART2,VALEUR) values("+i+","+ itemId + "," + recommendation.getItemID() + "," + recommendation.getValue() + ")");
				}

			}
		} catch (IOException e) {
			System.out.println("There was an error.");
			e.printStackTrace();
		} catch (TasteException e) {
			System.out.println("There was a Taste Exception");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}