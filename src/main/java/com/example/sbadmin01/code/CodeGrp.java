package com.example.sbadmin01.code;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "CMM_CODE_GRP")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CodeGrp {
    @Id
    private String codeGrpId;

    @Column(length=50)
    private String codeId;

    @Column(length=100)
    private String codeName;

    @Column(length=200)
    private String codeDesc;

    @Column(length=100)
    private String codeEngName;

    @Column(length=9)
    private int showRankNo;

    @Column(length=1)
    private String useYn;

    @Column(length=50)
    private String registUserId;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime createdAt;
}
