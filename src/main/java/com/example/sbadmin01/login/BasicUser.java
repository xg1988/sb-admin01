package com.example.sbadmin01.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "basic_user")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BasicUser {
    @Id
    @NotEmpty
    private String user_id;

    @Size(min = 1, max = 50)
    private String password;
    private String id_type;
    private String user_name;
    private String email;
    private String birthday;
    private LocalDateTime login_date;
    private LocalDateTime regist_date;
}
