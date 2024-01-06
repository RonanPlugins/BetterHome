package com.ronancraft.BetterHome.database;

import com.ronancraft.BetterHome.BetterHome;
import com.ronancraft.BetterHome.helpers.HelperDatabase;
import com.ronancraft.BetterHome.player.PlayerData;
import org.bukkit.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class DatabasePlayers extends SQLite {

    public DatabasePlayers() {
        super(DATABASE_TYPE.PLAYERS);
    }

    @Override
    public List<String> getTables() {
        List<String> list = new ArrayList<>();
        list.add("Players");
        return list;
    }

    public enum COLUMNS {
        UUID("uuid", "varchar(32) PRIMARY KEY"),
        //COOLDOWN DATA
        PRIMARY_HOME("home", "TEXT"),
        LAST_HOME_DATE("last_home_date", "DATETIME"),
        OTHER_HOMES("other_homes", "TEXT"),
        ;

        public final String name;
        public final String type;

        COLUMNS(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    public void setupData(PlayerData data) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getSQLConnection();
            ps = conn.prepareStatement("SELECT * FROM " + tables.get(0) + " WHERE " + COLUMNS.UUID.name + " = ?");
            ps.setString(1, data.player.getUniqueId().toString());

            rs = ps.executeQuery();
            if (rs.next()) {
                Location home = HelperDatabase.getLocationFromJson(rs.getString(COLUMNS.PRIMARY_HOME.name));
                data.setLastHomeDate(rs.getDate(COLUMNS.LAST_HOME_DATE.name));
                data.setDefaultHome(home);
            }
        } catch (SQLException ex) {
            BetterHome.getInstance().getLogger().log(Level.SEVERE, Errors.sqlConnectionExecute(), ex);
        } finally {
            close(ps, rs, conn);
        }
    }

    //Save players Home(s)
    public void setData(PlayerData data) {
        String pre = "INSERT OR REPLACE INTO ";
        String sql = pre + tables.get(0) + " ("
                + COLUMNS.UUID.name + ", "
                + COLUMNS.PRIMARY_HOME.name + ", "
                + COLUMNS.LAST_HOME_DATE.name + " "
                //+ COLUMNS.USES.name + " "
                + ") VALUES(?, ?, ?)";
        List<Object> params = new ArrayList<Object>() {{
                add(data.player.getUniqueId().toString());
                add(data.getDefaultHome());
                add(data.getLastHomeDate());
                //add(data.getUses());
        }};
        sqlUpdate(sql, params);
    }
}