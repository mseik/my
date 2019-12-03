import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class test {




   public static  void main(String[] args ) {
BigDecimal  decimal=new BigDecimal("0125");

      System.out.println(decimal);
   }

public static boolean isNum(String obj) {
   Pattern pattern = Pattern.compile("[0-9]*");
   if(obj.toCharArray()[0]=='-'){
      return false;
   }
   if(obj.toCharArray()[0]=='0'){
      String[] s=obj.split("");
      List<String>  f= new ArrayList<>();
      f.addAll(Arrays.asList(s));
      f.remove(0);
      obj=StringUtils.join(f,"");
   }
   if (obj.indexOf(".") > 0) {
      if (obj.indexOf(".") == obj.lastIndexOf(".") && obj.split("\\.").length == 2) {
         return pattern.matcher(obj.replace(".", "")).matches();
      } else {
         return false;
      }
   } else {
      return pattern.matcher(obj).matches();
   }
}

}
