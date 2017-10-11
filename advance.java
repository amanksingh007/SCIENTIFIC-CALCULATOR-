import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author welcome
 */
public class advance extends javax.swing.JFrame {
    final static int GARBAGE=-123456;
    static String guestname="";
    static String memory="";
    
    public static int factorial(int n){
	 int i=1,res=1;
	 for(i=1;i<=n;i++)
		 res*=i;
	 return(res);
    }
    
     public static int isOperator(char ch){
	if(ch== '+' || ch== '-' || ch== '*' || ch == '/' || ch=='^' || ch=='s' || ch=='S' || ch=='t')
		return(1);
	else
		if(ch=='c' || ch=='C' || ch=='l' || ch=='L' || ch=='!' || ch == 'r' || ch=='R' || ch=='T' )
			return(1);
		else
			if(ch=='h' || ch=='m' || ch=='n' || ch=='x')
				return(1);
     else
		 return(0);
	}
 public static int isAlpha(char ch){
	 if(ch=='s' || ch=='S')
		 return(1);
	 else
	 if(ch=='c' || ch=='C')
		 return(1);
	 else
	 if(ch=='t' || ch=='T')
		 return(1);
	 else
	 if(ch=='l' || ch=='L')
		 return(1);
	 else
	 if(ch=='r' || ch=='R')
		 return(1);
	 if(ch=='h' || ch=='m')
		 return(1);
	 if(ch=='n' || ch=='!')
		 return(1);
	 if(ch=='x')
		 return(1);
	 else
		 return(0);
 }
	
public static double evaluate(String expression){
		System.out.println(expression);
		char[] array = expression.toCharArray();
		//System.out.println(array[0]);
		Stack<Double> stack = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < array.length; i++){
			//System.out.println("i:"+i);
                        if(array[0]=='-' && i==0){
				i+=2;
				StringBuilder x=new StringBuilder();
				while((i<array.length) && ((array[i] >= '0' && array[i] <= '9')||(array[i]=='.'))){
					x.append(array[i]);
					i++;
				}
				System.out.println(x);
				String num="-"+x;
				System.out.println("NUM:"+num);
				stack.push(Double.parseDouble(num));
                                if(i>=array.length)
                                    break;
				}
                        System.out.println("I:"+i);
			if (array[i] == ' ')
				continue;
			if (array[i] >= '0' && array[i] <= '9'){
				StringBuilder sbuf = new StringBuilder();
				while((i<array.length) && ((array[i] >= '0' && array[i] <= '9')||(array[i]=='.'))){
					sbuf.append(array[i++]);
				}
				//System.out.println(sbuf);
				//System.out.println("i:"+i);
				stack.push(Double.parseDouble(sbuf.toString()));
				
			}
			else 
				if (array[i] == '('){
					System.out.println(i+"(");
				operators.push(array[i]);
				}
			    else 
					if (array[i] == ')'){
						System.out.println(i+")");
				      while (operators.peek() != '('){
						  char opr=operators.pop();
						  if(advance.isAlpha(opr)==1){
							  double res=applyOp(opr, stack.pop(), 1);
									System.out.println("RES"+res);
							  stack.push(res);
						  }
						  else{
							  double res=applyOp(opr, stack.pop(), stack.pop());
									System.out.println("RES"+res);
				        stack.push(res);
						  }
					  }
				      operators.pop();
			       }
			       else 
				    if (advance.isOperator(array[i])==1){
						System.out.println("op:"+array[i]);
						
				            while (!operators.empty() && hasPrecedence(array[i])<=hasPrecedence(operators.peek()) &&operators.peek()!='('){
								char opr=operators.pop();
								if(advance.isAlpha(opr)==1){
									double res=applyOp(opr,stack.pop(),1);
									System.out.println("RES"+res);
							       stack.push(res);
								}
						        else{
									double res=applyOp(opr, stack.pop(), stack.pop());
									System.out.println("RES"+res);
				                   stack.push(res);
								}
						        System.out.println("STACK TOP:"+stack.peek());
					  
				              // stack.push(applyOp(operators.pop(), stack.pop(), stack.pop()));
							  }
				            operators.push(array[i]);
							System.out.println("OP:"+operators.peek());
			        }
					//System.out.println(stack.peek());
					//System.out.println(operators.peek());
		  }
          try{
		  while (!operators.empty()){
			  char opr=operators.pop();
						  if(advance.isAlpha(opr)==1){
							  double res=applyOp(opr, stack.pop(), 1);
									System.out.println("RES"+res);
							  stack.push(res);
						  }
						  else{
							  double res=applyOp(opr, stack.pop(), stack.pop());
									System.out.println("RES"+res);
				        stack.push(res);
						  }
			//stack.push(applyOp(operators.pop(), stack.pop(), stack.pop()));
		  }
	       }
	       catch(Exception x){
		     System.out.println("EXCEPTION");
		      return(-123456);
	      }
		
		return stack.pop();
	
	}
	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	/*public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')' || op2=='s' || op2=='c' || op2=='l' || op2=='L' || op2=='r'){
			System.out.println("1..");
			return false;
		}
		if((op2=='s' || op2=='c' || op2=='l' || op2=='L' || op2=='r')&&(op2 == '+' || op2 == '-'))
		{System.out.println("2..");
			return false;
		}
		if ((op1=='^' ||op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
			System.out.println("3..");
			return false;
		}
		else
			return true;
	}
*/
     
    public static int hasPrecedence(char op)
	{
		if (op== '(' || op== ')'){// || op2=='s' || op2=='c' || op2=='l' || op2=='L' || op2=='r')
			System.out.println("5..");
			return 5;
		}
		if(advance.isAlpha(op)==1){
			System.out.println("4..");
			return 4;
		}
		if ((op=='^' ||op == '*' || op == '/')){// && (op2 == '+' || op2 == '-')){
			System.out.println("3..");
			return 3;
		}
		else
			if(op== '+' || op== '-'){
				System.out.println("2..");
				return 2;
			}
			return 0;
	}
	
	public static double applyOp(char op, double b, double a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException("WRONG INPUT AS DIVISOR");
			return a / b;
	    case '^':
		         return(Math.pow(a,b));
		case 's': 
                        //if(advance.rb1.isSelected())
		        return(Math.sin(Math.toRadians(b)));
		case 'c': 
		        return(Math.cos(Math.toRadians(b)));
		case 't': 
		        return(Math.tan(Math.toRadians(b)));
		case 'r': 
		        return(Math.sqrt(b));
		case 'R': 
		        return(Math.cbrt(b));
		case 'l': 
		        return(Math.log10(b));
		case 'L': 
		        return (Math.log(b));
		case 'S': 
		        return(Math.asin(b));
		case 'h': 
		        return(Math.sinh(b));
		case 'm': 
		        return(Math.cosh(b));
		case 'n': 
		        return(Math.tanh(b));
		case '!': 
		        return((double)advance.factorial((int)b));
		case 'x': 
		        return(Math.exp(b));
				
		}
		return 0;
	}
   
   
	 public static String modify(String exp){
		 exp=exp.replaceAll("sinh","l");
		 exp=exp.replaceAll("cosh","m");
		 exp=exp.replaceAll("tanh","n");
		 exp=exp.replaceAll("asin","S");
		 exp=exp.replaceAll("acos","C");
		 exp=exp.replaceAll("atan","T");
		 exp=exp.replaceAll("sin","s");
		 exp=exp.replaceAll("cos","c");
		 exp=exp.replaceAll("tan","t");
		 exp=exp.replaceAll("log","l");
		 exp=exp.replaceAll("ln","L");
		 exp=exp.replaceAll("sqrt","r");
		 exp=exp.replaceAll("cbrt","R");
		 exp=exp.replaceAll("exp","x");
                 exp=exp.replaceAll("PI","3.141592654");
                 exp=exp.replaceAll("e","2.7182828");
		 return(exp);
		 
	 }
	
    
    
    
    
    

    /**
     * Creates new form advance
     */
    public advance() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        l1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        btnResult = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        btnResult1 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 0));
        setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setText(" 7");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 50, 39));

        jButton9.setText(" 8");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 50, 39));

        jButton10.setText(" 9");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 50, 39));

        jButton11.setText(" +");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 50, 39));

        jButton12.setText(" -");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 50, 39));

        jButton13.setText(" 4");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 50, 39));

        jButton14.setText(" 5");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 50, 39));

        jButton15.setText(" 6");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 50, 39));

        jButton16.setText(" *");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 50, 39));

        jButton17.setText(" 1");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 50, 39));

        jButton18.setText(" 2");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 50, 39));

        jButton19.setText(" 3");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 50, 39));

        jButton20.setText(" )");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 50, 39));

        jButton1.setText(" sin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 60, 39));

        jButton2.setText(" cos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 60, 39));

        jButton3.setText(" tan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, 39));

        jButton4.setText(" sqrt");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 60, 39));

        jButton5.setText(" x!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 60, 39));

        jButton6.setText(" atan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 60, 39));

        jButton7.setText(" exp");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 60, 39));

        jButton24.setText(" log");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 60, 39));

        jButton25.setText(" ln");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 60, 39));

        l1.setEditable(false);
        l1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        l1.setText(" ");
        l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1ActionPerformed(evt);
            }
        });
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("RESULT :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 54, 160, 30));

        t1.setEditable(false);
        t1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 40, 220, 50));

        jButton29.setText(" RESET");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 39));

        jButton31.setText(" (");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 50, 39));

        jButton32.setText(" EXIT");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 100, 39));

        btnResult.setText(" =");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });
        getContentPane().add(btnResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 50, 39));

        jButton35.setText(" <-");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 50, 39));

        jButton36.setText(" /");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 50, 39));

        jButton37.setText(" .");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 50, 39));

        jButton38.setText(" 0");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 50, 39));

        btnResult1.setText(" ^");
        btnResult1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResult1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnResult1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 50, 39));

        jButton21.setText(" CLICK TO SEE HISTORY");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 420, 40));

        jButton22.setText(" ANS");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 60, 40));

        jButton23.setText(" cbrt");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 60, 39));

        jButton27.setText(" asin");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 60, 39));

        jButton28.setText(" acos");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 60, 39));

        jButton30.setText("  e");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 60, 39));

        jButton33.setText(" PI");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 60, 39));

        jButton34.setText(" sinh");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 60, 39));

        jButton39.setText(" cosh");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 60, 39));

        jButton40.setText(" tanh");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 60, 39));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    String s;
        s=(l1.getText())+"8";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    String s;
        s=(l1.getText())+"9";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    String s;
        s=(l1.getText())+" + ";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
    String s;
        s=(l1.getText())+" - ";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
    String s;
        s=(l1.getText())+"5";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
    String s;
        s=(l1.getText())+"6";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
    String s;
        s=(l1.getText())+" * ";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
    String s;
        s=(l1.getText())+"2";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    String s;
        s=(l1.getText())+"3";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
    String s;
        s=(l1.getText())+" ) ";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
    this.getContentPane().setBackground(Color.blue);
        l1.setText("");
    t1.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
    //this.getContentPane().setBackground(Color.red);
    String cmd;
    StringBuilder exp=new StringBuilder(1000);  
   
    
    //Scanner sc=new Scanner(System.in);
    //String s=sc.nextLine();
    
    String s=l1.getText();
           
    exp.append(s);
    String mySqlExp=""+s;
    int i,flag=0,start=-1,end=-1;
    float ans=0f;
    
    //   REDUCING THE COMPLEX EQUATION
    
    String str=advance.modify(exp.toString());
    
    //    EQUATION SIMPLIFIED
    
    //System.out.println(exp);
    float res=(float)advance.evaluate(str.trim());
    if(res!=-123456){
	//System.out.println(res);
        t1.setText(""+res);
        memory=t1.getText();
    }
    else
        //System.out.println("SYNTAX ERROR");
        JOptionPane.showMessageDialog(null,"YOUR SYNTAX IS WRONG!");
    
       
         //SQL CODE BEGINS.............
    
        String url="jdbc:mysql://localhost:3306/mydatabase" +   // SELECT @@port; SELECT @@hostname;
	             "?verifyServerCertificate=false"+ "&useSSL=false"
                    + 
					"&requireSSL=false";
	 String username="aksingh";
	 String pwd="aman1997";
	
	
	

	try{
	Class.forName("com.mysql.jdbc.Driver");
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection con=DriverManager.getConnection(url,username,pwd);
	
	//System.out.print("ENTER YOUR mySql COMMAND :");
	//Scanner sc=new Scanner(System.in);
	//String cmd=sc.nextLine();
        cmd="insert into history(username,expression,result) values(" + "\"" + guestname + "\",\"" + mySqlExp + "\",\"" +res +"\");";
        
	Statement stm=con.createStatement();
       // System.out.println(cmd);
	int n=stm.executeUpdate(cmd);
	
	//while(rs.next())
	//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));

	con.close();

        }
        catch(Exception e){
            System.out.println("CANNOT CONNECT TO DATABASE");
        }
         
         
         
         //SQL CODE ENDS..........
         
    }//GEN-LAST:event_btnResultActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
       String s,str;
       s=l1.getText();
       int l=s.length();
       l1.setText("");
       str=s.substring(0,l-1);
       l1.setText(str);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
    String s;
    s=(l1.getText())+" / ";
    l1.setText(s);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
      String s;
        s=(l1.getText())+"1";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    String s;
        s=(l1.getText())+"4";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    String s;
        s=(l1.getText())+"7";

        l1.setText(s);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
    String s;
        s=(l1.getText())+".";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
    String s;
        s=(l1.getText())+" ( ";
        l1.setText(s);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
    String s;
    s=(l1.getText())+"0";
    l1.setText(s);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String s;
        s=(l1.getText())+"sin( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String s;
        s=(l1.getText())+"cos( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String s;
        s=(l1.getText())+"tan( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    String s;
        s=(l1.getText())+"exp( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
    String s;
        s=(l1.getText())+"log( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
    String s;
        s=(l1.getText())+"ln( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String s;
        s=(l1.getText())+"sqrt( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    String s;
        s=(l1.getText())+" ! ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String s;
        s=(l1.getText())+"atan( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnResult1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResult1ActionPerformed
     String s;
        s=(l1.getText())+" ^ ";

        l1.setText(s);   // TODO add your handling code here:
    }//GEN-LAST:event_btnResult1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        new history().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
    /*new choice().setVisible(true);
    this.setVisible(false);// TODO add your handling code here:
        */
       String s=l1.getText();
       l1.setText(s+memory);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
    String s;
        s=(l1.getText())+"cbrt( ";

        l1.setText(s);               // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
    String s;
        s=(l1.getText())+"asin( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
    String s;
        s=(l1.getText())+"acos( ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
    String s;
        s=(l1.getText())+" e ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
     String s;
        s=(l1.getText())+" PI ";

        l1.setText(s);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void l1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(advance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(advance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(advance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(advance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                String msg;
                guestname=JOptionPane.showInputDialog("ENTER YOUR NAME");
                //guestname="Mr. X";
                msg="WELCOME Mr."+guestname+" !!!";
                JOptionPane.showMessageDialog(null,msg);
                //new MY_CALCI().setVisible(true);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new advance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResult;
    private javax.swing.JButton btnResult1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField l1;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
