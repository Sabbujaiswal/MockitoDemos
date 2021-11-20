package com.mobileapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobileapp.exceptions.IdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileRepositoryImpl implements IMobileRepository {
	static Connection connection;

	public void addMobile(Mobile mobile) {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, mobile.getModel());
			statement.setString(2, mobile.getBrand());
			statement.setString(3, mobile.getOs());
			statement.setDouble(4, mobile.getPrice());
			statement.setString(5, mobile.getStorage());
			statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ModelDAO.closeConnection();
			}

		}

	}

	public void updateMobile(int mobileId, double price) throws IdNotFoundException {

		// TODO Auto-generated method stub
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.UPDATEQUERY);

			statement.setDouble(1, price);
			statement.setInt(2, mobileId);

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ModelDAO.closeConnection();
			}
		}

	}

	public Mobile findById(int mobileId) throws IdNotFoundException {
		PreparedStatement statement = null;
		Mobile mobile = null;
		Connection connection = ModelDAO.openConnection();

		try {
			statement = connection.prepareStatement(Queries.SELECTBYIDQUERY);
			statement.setInt(1, mobileId);
			ResultSet resultset = null;
			resultset = statement.executeQuery();
			while (resultset.next()) {
				mobile = new Mobile();
				mobile.setBrand(resultset.getString("brand"));
				mobile.setModel(resultset.getString("model"));
				mobile.setStorage(resultset.getString("storage"));
				mobile.setOs(resultset.getString("os"));
				mobile.setPrice(resultset.getFloat("price"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

		return mobile;
	}

	public void deleteMobile(int mobileId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		try {
		statement = connection.prepareStatement(Queries.DELETEQUERY);
		statement.setInt(1, mobileId);
		boolean result = statement.execute();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
		if (statement != null) {
		try {
		statement.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		ModelDAO.closeConnection();
		}
		}

	}

	public List<Mobile> findAll() {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
		statement = connection.prepareStatement(Queries.SELECTALLQUERY);
		resultset = statement.executeQuery();
		while (resultset.next()) {
		String model = resultset.getString("model");
		String brand = resultset.getString("brand");
		String os = resultset.getString("os");
		Float price = resultset.getFloat("price");
		String storage = resultset.getString("storage");

		Mobile mobile = new Mobile(model, brand, storage, os, price);
		//mobile.setMobileId(resultset.getInt("mobileid"));
		mobileList.add(mobile);

		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
		if (statement != null) {
		try {
		statement.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		ModelDAO.closeConnection();
		}

		}
		return mobileList;

		
		
	}

	public List<Mobile> findByBrand(String brand) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
		statement = connection.prepareStatement(Queries.GETBYBRANDQUERY);

		statement.setString(1, brand);
		resultset = statement.executeQuery();
		while (resultset.next()) {
		String model = resultset.getString("model");
		String branded = resultset.getString("brand");
		String os = resultset.getString("os");
		Float price = resultset.getFloat("price");
		String storage = resultset.getString("storage");

		Mobile mobile = new Mobile(model, branded, storage, os, price);
		//mobile.setMobileId(resultset.getInt("mobileid"));
		mobileList.add(mobile);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		if (mobileList.isEmpty()) {
		throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
		
		
	}

	public List<Mobile> findByBrandAndModel(String model, String brand) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
		statement = connection.prepareStatement(Queries.GETBRANDMODELQUERY);

		statement.setString(1, brand);
		statement.setString(2, model + "%");
		resultset = statement.executeQuery();
		while (resultset.next()) {
		String searchedModel = resultset.getString("model");
		String searchedbrand = resultset.getString("brand");
		String os = resultset.getString("os");
		Float price = resultset.getFloat("price");
		String storage = resultset.getString("storage");

		Mobile mobile = new Mobile(searchedModel, searchedbrand, storage, os, price);
		//mobile.setMobileId(resultset.getInt("mobileid"));
		mobileList.add(mobile);
		}

		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		if (statement != null) {
		try {
		statement.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		ModelDAO.closeConnection();
		}

		}

		if (mobileList.isEmpty()) {
		throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

	public List<Mobile> findByOs(String os) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
		statement = connection.prepareStatement(Queries.GETBYOSQUERY);

		statement.setString(1, os);
		resultset = statement.executeQuery();
		while (resultset.next()) {
		String model = resultset.getString("model");
		String branded = resultset.getString("brand");
		String os1 = resultset.getString("os");
		Float price = resultset.getFloat("price");
		String storage = resultset.getString("storage");

		Mobile mobile = new Mobile(model, branded, storage, os1, price);
		//mobile.setMobileId(resultset.getInt("mobileid"));
		mobileList.add(mobile);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
		if (statement != null) {
		try {
		statement.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		ModelDAO.closeConnection();
		}

		}

		if (mobileList.isEmpty()) {
		throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

	public List<Mobile> findByLasserPrice(double lowerPrice) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
		statement = connection.prepareStatement(Queries.GETPRICEQUERY);

		statement.setDouble(1, lowerPrice);
		resultset = statement.executeQuery();
		while (resultset.next()) {
		String model = resultset.getString("model");
		String branded = resultset.getString("brand");
		String os = resultset.getString("os");
		Float price = resultset.getFloat("price");
		String storage = resultset.getString("storage");

		Mobile mobile = new Mobile(model, branded, storage, os, price);
		//mobile.setMobileId(resultset.getInt("mobileid"));
		mobileList.add(mobile);
		}

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
		if (statement != null) {
		try {
		statement.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		ModelDAO.closeConnection();
		}

		}

		if (mobileList.isEmpty()) {
		throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

}
