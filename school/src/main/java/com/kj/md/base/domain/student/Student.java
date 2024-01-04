package com.kj.md.base.domain.student;

import com.kj.md.base.code.StudentCode.GENDER;
import com.kj.md.base.convertor.GenderConverter;
import com.kj.md.base.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class Student extends BaseDomain
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(length = 10, nullable = false)
    private String studentName;

    @Convert(converter = GenderConverter.class)
    private GENDER gender;

    private Integer age;
}
