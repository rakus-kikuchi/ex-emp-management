package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;

//administrators table

@Repository
public class AdministratorRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;
    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPWE = (rs,i)->{
        Administrator admin = new Administrator();
        admin.setId(rs.getInt("id"));
        admin.setName(rs.getString("name"));
        admin.setMailAddress(rs.getString("mail_address"));
        admin.setPassword(rs.getString("password"));
        return admin;
    };

    public void insert(Administrator administrator) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        if (administrator.getId() == null) {
            String sql = "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress, :password); ";
             template.update(sql, param);
        }else{
            String sql = "UPDATE administrators SET name =:name, mail_address=:mailAddress, password=:password WHERE id=:id ;";
            template.update(sql, param);
        }
        System.out.println("insertメソッドが呼び出されました");
    }

    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address= :mail_address AND password = :password; ";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
        Administrator admin = template.queryForObject(sql,param, ADMINISTRATOR_ROW_MAPPWE);
        System.out.println("findBymailAndpassメソッドを呼び出しました");
        return admin;
    }

}
