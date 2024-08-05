CREATE TABLE IF NOT EXISTS doctor
(
    id        BIGSERIAL,
    firstname VARCHAR,
    lastname  VARCHAR,
    dob       DATE,
    phone     VARCHAR UNIQUE,
    email     VARCHAR UNIQUE,
    position  VARCHAR,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS schedule
(
    id             BIGSERIAL,
    schedule_start DATE,
    schedule_end   DATE,
    doctor_id      BIGINT,

    PRIMARY KEY (id),
    FOREIGN KEY (doctor_id) REFERENCES doctor (id)
);

CREATE TABLE IF NOT EXISTS patient
(
    id              BIGSERIAL,
    firstname       VARCHAR,
    lastname        VARCHAR,
    gender          VARCHAR,
    phone           VARCHAR UNIQUE,
    email           VARCHAR UNIQUE,
    dob             DATE,
    address         VARCHAR,
    doctor_id       BIGINT,
    security_number VARCHAR UNIQUE,

    PRIMARY KEY (id),
    FOREIGN KEY (doctor_id) REFERENCES doctor (id)
);

CREATE TABLE IF NOT EXISTS health_record
(
    id          BIGSERIAL,
    patient_id  BIGINT,
    name        VARCHAR,
    description VARCHAR,
    start       DATE,
    finish      DATE,
    medication  VARCHAR,

    PRIMARY KEY (id),
    FOREIGN KEY (patient_id) REFERENCES patient (id)
);







