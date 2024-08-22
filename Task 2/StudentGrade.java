import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentGrade {
    float marathi,hindi,english,math,science,total,per;
    public void input(){
        Scanner in=new Scanner(System.in);
        System.out.println("-------Enter your Marks-------");
        System.out.print("Marathi : ");
        marathi= in.nextFloat();
        System.out.print("Hindi : ");
        hindi=in.nextFloat();
        System.out.print("English : ");
        english=in.nextFloat();
        System.out.print("Mathematics : ");
        math=in.nextFloat();
        System.out.print("Science : ");
        science=in.nextFloat();
    }
    public void totalmarks(){
        total=marathi+hindi+english+math+science;
        System.out.println("Total marks of student : "+total);
    }
    public void percentage(){
        per=total/5;
        System.out.println("Average Percentage : "+per);
    }
    public void grade()
    {
        if(per>85){
            System.out.println("Grade : A");
        }
        else if(per>70){
            System.out.println("Grade : B");
        }
        else if(per>55){
            System.out.println("Grade  : C");
        }
        else if(per>35){
            System.out.println("Grade : D");
        }
        else{
            System.out.println("Grade not available! Fail.");
        }
    }
    public static void main(String[] args) {
        StudentGrade sg=new StudentGrade();
        sg.input();
        System.out.println("------------------------------");
        sg.totalmarks();
        sg.percentage();
        sg.grade();
        System.out.println("------------------------------");
    }
}
