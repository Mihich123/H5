package mihich;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

    private String position;// 职位
    private String company;// 公司名
    private String workplace;// 工作地点
    private String compensation;// 薪资
    private String date;// 发布日期

    public Job() {
    }

    public Job(String position, String company, String compensation, String workplace, String date) {
        this.position = position;
        this.company = company;
        this.compensation = compensation;
        this.workplace = workplace;
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Job{" +
                "position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", compensation='" + compensation + '\'' +
                ", workplace='" + workplace + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
