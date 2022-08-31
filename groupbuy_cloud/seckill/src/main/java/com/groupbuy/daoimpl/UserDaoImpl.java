package com.groupbuy.daoimpl;

import com.groupbuy.dao.UserDao;
import com.groupbuy.entity.Address;
import com.groupbuy.entity.User;
import com.groupbuy.entity.UserHistory;
import com.groupbuy.repository.AddressesRepository;
import com.groupbuy.repository.UserHistoryRepository;
import com.groupbuy.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private UserRepository userRepository;
    @Resource
    private AddressesRepository addressesRepository;

    @Resource
    private UserHistoryRepository userHistoryRepository;

    @Override
    public User findById(int id) {
        return userRepository.findByUserId(id);
    }


    @Override
    public User checkUser(String userName, String password) {
        return userRepository.checkUser(userName, password);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Address saveAddress(Address address) { return addressesRepository.save(address);}

    @Override
    public Set<UserHistory> findUserHistoryByUser(User user) {
        return userHistoryRepository.findByUser(user);
    }

    @Override
    public UserHistory findByUserAndAndCategory(User user, String category) {
        return userHistoryRepository.findByUserAndCategory(user, category);
    }

    @Override
    public void updateLiking(Integer newLiking, Integer userId, String category) {
        userHistoryRepository.updateLiking(newLiking, userId, category);
    }

    @Override
    public UserHistory saveUserHistory(UserHistory userHistory) {
        return userHistoryRepository.save(userHistory);
    }
}
