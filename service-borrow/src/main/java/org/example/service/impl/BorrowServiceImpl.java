package org.example.service.impl;

import jakarta.annotation.Resource;
import org.example.dto.UserBorrowDetail;
import org.example.entity.Book;
import org.example.entity.Borrow;
import org.example.entity.User;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.example.service.client.BookClient;
import org.example.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Resource
    UserClient userClient;
    @Resource
    BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrowList = borrowMapper.getBorrowsByUid(uid);
        User user = userClient.findUserById(uid);
        List<Book> bookList = borrowList
                .stream()
                .map(book -> bookClient.findBookById(book.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
