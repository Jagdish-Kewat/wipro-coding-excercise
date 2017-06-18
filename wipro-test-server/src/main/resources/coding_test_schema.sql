CREATE TABLE wipro_test.courses (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  duration INT NOT NULL,
  durationType VARCHAR(45) NOT NULL,
  deleted INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE INDEX name_UNIQUE (name ASC));

CREATE TABLE wipro_test.universities (
  id INT NOT NULL AUTO_INCREMENT,
  universityId INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  courseId INT NOT NULL,
  deleted INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  CONSTRAINT fk_university_course_id
    FOREIGN KEY (id)
    REFERENCES wipro_test.courses (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE wipro_test.students (
  id INT NOT NULL,
  studentId INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  courseId INT NOT NULL,
  deleted INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  INDEX fk_student_course_id_idx (courseId ASC),
  CONSTRAINT fk_student_course_id
    FOREIGN KEY (courseId)
    REFERENCES wipro_test.courses (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


