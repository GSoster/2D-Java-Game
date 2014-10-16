package map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapControll {

	private int map[][];

	public void readMapFromFile(String fileName)
			throws FileNotFoundException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		try {
			int rowNumber = Integer.parseInt(reader.readLine());
			int colNumer = Integer.parseInt(reader.readLine());
			map = new int[rowNumber][colNumer];
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
