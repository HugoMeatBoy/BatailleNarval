package export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class CsvExport {
    public void export(Integer test1,Integer test2,Integer test3) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("ProofOfConceptIAs.csv"));
        StringBuilder sb = new StringBuilder();
/*        AI Name; score; AI Name2; score2
        AI Level Beginner; X1; Level Medium; Y1
        AI Level Beginner;X2;Level Hard;Y2
        AI Medium;X3;Level Hard;Y3
*/

        sb.append("AI Name");
        sb.append(',');
        sb.append("score");
        sb.append(',');
        sb.append("AI Name2");
        sb.append(',');
        sb.append("score2");
        sb.append('\n');

        sb.append("AI Lvl 1");
        sb.append(',');
        sb.append((100-test1));
        sb.append(',');
        sb.append("AI Lvl 2");
        sb.append(',');
        sb.append(test1.toString());
        sb.append('\n');

        sb.append("AI Lvl 1");
        sb.append(',');
        sb.append((100 - test2));
        sb.append(',');
        sb.append("AI Lvl 3");
        sb.append(',');
        sb.append(test2.toString());
        sb.append('\n');

        sb.append("AI Lvl 2");
        sb.append(',');
        sb.append((100-test3));
        sb.append(',');
        sb.append("AI Lvl 3");
        sb.append(',');
        sb.append(test3.toString());
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}
