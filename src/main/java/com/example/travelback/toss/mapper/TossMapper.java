package com.example.travelback.toss.mapper;

import com.example.travelback.toss.domain.Toss;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TossMapper {

    @Insert("""
                insert into travel.ttoss (id, amount,orderId,userId ) values (#{id},#{amount},#{orderId} ,#{userId});
        """)
    int save(Integer id, Integer amount, String orderId, String userId);


    @Select("""
                select tossid,transTitle,transStartDate,transEndDate,request,reservation,userId,amount
                 from travel.ttoss 
                  left join travel.transport t on t.tId = ttoss.id 
                  where  userId=#{userId};
        """)
    List<Toss> getId(String userId);
}

