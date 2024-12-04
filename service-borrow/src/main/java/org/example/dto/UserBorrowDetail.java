package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Book;
import org.example.entity.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> bookList;
}
