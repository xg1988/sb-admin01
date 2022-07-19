package com.example.sbadmin01.login;


import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<BasicUser, String> {
}
