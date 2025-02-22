package com.example.finalproject6.service;

import com.example.finalproject6.DesignPattern.TemplateMethodPattern.AbstractCRUDService;
import com.example.finalproject6.mapper.TransactionMapper;
import com.example.finalproject6.pojo.Item;
import com.example.finalproject6.pojo.Transaction;
import com.example.finalproject6.pojo.UserVo;
import com.example.finalproject6.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Service
public class TransactionServiceImpl extends AbstractCRUDService<Transaction> {

    @Autowired
    private TransactionMapper transactionMapper;


    @Override
    public List<Transaction> getAll() {
        System.out.println("masukkkkk");
        UserVo uv = ThreadLocalUtil.get();
        if (uv == null) {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(false);
            if (session != null) {
                uv = (UserVo) session.getAttribute("cu");
                // Set it in ThreadLocalUtil for future use
                if (uv != null) {
                    ThreadLocalUtil.set(uv);
                }
            }
        }

        if (uv == null) {
            throw new NullPointerException("UserVo is null");
        }
        Integer userId = uv.getUserId();
        return transactionMapper.showCart(userId);
    }


    public Transaction findItemById(Integer Id) {
        return null;
    }

    @Override
    public void addItem(Transaction transaction) {
        System.out.println("masukk");
        UserVo uv = ThreadLocalUtil.get();
        if (uv == null) {
            HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getSession(false);
            if (session != null) {
                uv = (UserVo) session.getAttribute("cu");
                if (uv != null) {
                    ThreadLocalUtil.set(uv);
                }
            }
        }

        if (uv == null) {
            throw new NullPointerException("UserVo is null");
        }
        System.out.println(uv);
        Integer userId = uv.getUserId();
        transaction.setUserId(userId);
        transactionMapper.addItemToCart(transaction);
    }

    @Override
    public void update(Transaction entity) {

    }

    @Override
    public void delete(Integer transactionId) {
        transactionMapper.delete(transactionId);
    }
}
