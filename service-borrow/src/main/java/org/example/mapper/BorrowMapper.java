package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Borrow;

import java.util.List;


@Mapper
public interface BorrowMapper {
    @Select("select * from db_borrow where f_uid = #{uid}")
    @Results({
            @Result(property = "uid", column = "f_uid"),
            @Result(property = "bid", column = "f_bid")
    })
    List<Borrow> getBorrowsByUid(int uid);

    @Select("select * from db_borrow where f_bid = #{bid}")
    @Results({
            @Result(property = "uid", column = "f_uid"),
            @Result(property = "bid", column = "f_bid")
    })
    List<Borrow> getBorrowsByBid(int bid);

    @Select("select * from db_borrow where f_bid = #{bid} and f_uid = #{uid}")
    @Results({
            @Result(property = "uid", column = "f_uid"),
            @Result(property = "bid", column = "f_bid")
    })
    Borrow getBorrow(int uid, int bid);
}
