package datapackage;
import java.io.Serializable;

public class Disciplines implements Serializable {
     private static final long serialVersionUID = 1L;
     
     public int disid;
     public String discipline;
     public int lectid;
     public Lecturers lecturers;   
     
     public Disciplines(int disid, String discipline) {
        this.disid = disid;
        this.discipline = discipline;
    }

    public Disciplines(int disid, String discipline, int lectid, Lecturers lecturers) {
        this.disid = disid;
        this.discipline = discipline;
        this.lectid = lectid;
        this.lecturers = lecturers;     
    }

    public Disciplines() {        
    }

    public int getDisid() {
        return disid;
    }

    public void setDisid(int disid) {
        this.disid = disid;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
       public int getLectid() {
        return lectid;
    }

    public void setLectid(int lectid) {
        this.lectid = lectid;
    }

    public String getLecturers() {
        return lecturers.getName();
    }

    public void setLecturers(Lecturers lecturers) {
        this.lecturers = lecturers;
    }
   public String getLecturerssn() {
        return lecturers.getSurname();
    }

    public void setLecturerssn(Lecturers lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
        return "Disciplines{" + "disid=" + disid + ", discipline=" + discipline + ", lectid=" + lectid + ", lecturers=" + lecturers + '}';
    }


     
}
