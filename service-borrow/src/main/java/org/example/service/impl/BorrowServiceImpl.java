package org.example.service.impl;

import jakarta.annotation.Resource;
import org.example.dto.UserBorrowDetail;
import org.example.entity.Book;
import org.example.entity.Borrow;
import org.example.entity.User;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrowList = borrowMapper.getBorrowsByUid(uid);
        RestTemplate template = new RestTemplate();
        User user = template.getForObject("http://localhost:8000/user/" + uid, User.class);
        List<Book> bookList = borrowList
                .stream()
                .map(book -> template.getForObject("http://localhost:8200/book/" + book.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
