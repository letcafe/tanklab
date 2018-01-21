//package com.tanklab.dao.jdbc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class CRUDExample implements CRUDExampleInterface {
//
//    private static final String SELECT_ONE_DEVICE = "select id, device_id, device_name, device_description, price, lng, lat, owner_id, current_status from device where device_id = ?";
//
//    private static final String SELECT_MANY_BY_NAME = "select id, device_id, device_name, device_description, price, lng, lat, owner_id, current_status from device where device_name = ?";
//
//    private static final String ADD_ONE_DEVICE = "insert into device(device_id, device_name, device_description, price, lng, lat, owner_id, current_status) values(?, ?, ?, ?, ?, ?, ?, ?)";
//
//    private static final String DEL_ONE_DEVICE = "delete from device where device_id = ?";
//
//    private static final String UPDATE_ONE_DEVICE = "update device set device_name = ?, device_description = ?, price = ?, lng = ?, lat = ?, owner_id = ?, current_status = ? where device_id = ?";
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public CRUDExample(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public int count() {
//        return 0;
//    }
//
//    @Override
//    public Device selectOne(int id) {
//        try {
//            return jdbcTemplate.queryForObject(SELECT_ONE_DEVICE, new DeviceRowMapper(), id);
//        } catch(EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Device> selectByName(String deviceName) {
//        try {
//            return jdbcTemplate.query(SELECT_MANY_BY_NAME, new DeviceRowMapper(), deviceName);
//        } catch(EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public JDBC_STATUS deleteOne(int deviceId) {
//        int delCode = jdbcTemplate.update(DEL_ONE_DEVICE, deviceId);
//        if(delCode == 1) {
//            return JDBC_STATUS.SUCCESS;
//        }else {
//            return JDBC_STATUS.ERROR;
//        }
//    }
//
//    @Override
//    public JDBC_STATUS updateOne(Device device) {
//        int updateCode = jdbcTemplate.update(UPDATE_ONE_DEVICE,
//                device.getDevice_name(),
//                device.getDevice_description(),
//                device.getPrice(),
//                device.getLng(),
//                device.getLat(),
//                device.getOwner_id(),
//                device.getCurrent_status(),
//                device.getDevice_id()
//                );
//        if(updateCode == 1) {
//            return JDBC_STATUS.SUCCESS;
//        }else {
//            return JDBC_STATUS.ERROR;
//        }
//    }
//
//    @Override
//    public JDBC_STATUS addOne(Device device) {
//        int updateCode = jdbcTemplate.update(ADD_ONE_DEVICE,
//                device.getDevice_id(),
//                device.getDevice_name(),
//                device.getDevice_description(),
//                device.getPrice(),
//                device.getLng(),
//                device.getLat(),
//                device.getOwner_id(),
//                device.getCurrent_status());
//        if(updateCode > 0) {
//            return JDBC_STATUS.SUCCESS;
//        }else {
//            return JDBC_STATUS.FAIL;
//        }
//    }
//
//
//    private static final class DeviceRowMapper implements RowMapper<Device> {
//
//        @Override
//        public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
//            int id = rs.getInt("id");
//            int device_id = rs.getInt("device_id");
//            String device_name = rs.getString("device_name");
//            String device_description = rs.getString("device_description");
//            double price = rs.getDouble("price");
//            double lng = rs.getDouble("lng");
//            double lat = rs.getDouble("lat");
//            int owner_id = rs.getInt("owner_id");
//            int current_status = rs.getInt("current_status");
//            Device device = new Device(id, device_id, device_name, device_description, price, lng, lat, owner_id, current_status);
//            return device;
//        }
//    }
//}
