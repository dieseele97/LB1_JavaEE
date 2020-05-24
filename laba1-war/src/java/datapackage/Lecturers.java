package datapackage;

import java.io.Serializable;

public class Lecturers implements Serializable {
    private static final long serialVersionUID = 1L;
   public int lectid;
   public String name;
   public String surname;
   public String discipline;
   public Lecturers(){
   }
    public Lecturers(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Lecturers(int lectid, String name, String surname) {
        this.lectid = lectid;
        this.name = name;
        this.surname = surname;
    }

    public int getLectid() {
        return lectid;
    }

    public void setLectid(int lectid) {
        this.lectid = lectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Lecturers{" + "lectid=" + lectid + ", name=" + name + ", surname=" + surname + '}';
    }
   
}
