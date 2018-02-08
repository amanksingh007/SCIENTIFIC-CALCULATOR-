package com.example.calci2;

import java.util.Stack;

import com.example.calci2.R;
import com.example.calci2.*;
//import com.example.twoactivity.FirstActivity;
//import com.example.twoactivity.SecondActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,btnadd,btnsub,btnmult,btndiv,btnres,btnbrck1,btnbrck2
	,btnback,btnclear;
	private EditText t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_advanced);
		setContentView(R.layout.activity_main);
		initializeButtons();
		
		btn0.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"0").trim());
			}
		});
		

		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"1").trim());
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"2").trim());
			}
		});

		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"3").trim());
			}
		});
		
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"4").trim());
			}
		});
		
		btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"5").trim());
			}
		});
		
		btn6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"6").trim());
			}
		});
		
		btn7.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"7").trim());
			}
		});
		
		btn8.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"8").trim());
			}
		});
		
		btn9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+"9").trim());
			}
		});
		
		btndot.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+".").trim());
			}
		});
		
		btnadd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" + ").trim());
			}
		});
		
		btnsub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" - ").trim());
			}
		});
		
		btndiv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" / ").trim());
			}
		});
		
		btnmult.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" * ").trim());
			}
		});
		
		btnbrck1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" ( ").trim());
			}
		});

		btnbrck2.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				t1.setText(""+(t1.getText()+" ) ").trim());
			}
		});
		
		btnclear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText("");
			}
		});
		
		
		btnres.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String exp=(t1.getText()).toString();
				double ans=evaluate(exp);
				t1.setText(""+ans);
			}
		});
	}

	
	
	 public long factorial(int n){
		 int i=1;long res=1L;
		 for(i=1;i<=n;i++)
			 res*=i;
		 return(res);
	    }
	    
	     public int isOperator(char ch){
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
	     
	 public int isAlpha(char ch){
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
	 
	    public int hasPrecedence(char op)
		{
			if (op== '(' || op== ')'){// || op2=='s' || op2=='c' || op2=='l' || op2=='L' || op2=='r')
				System.out.println("5..");
				return 5;
			}
			if(isAlpha(op)==1){
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
		
		public double applyOp(char op, double b, double a)
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
			        return((double)factorial((int)b));
			case 'x': 
			        return(Math.exp(b));
					
			}
			return 0;
		}
	   
	   
		 public String modify(String exp){
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
		
		
	public double evaluate(String expression){
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
							  if(isAlpha(opr)==1){
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
					    if (isOperator(array[i])==1){
							System.out.println("op:"+array[i]);
							
					            while (!operators.empty() && hasPrecedence(array[i])<=hasPrecedence(operators.peek()) &&operators.peek()!='('){
									char opr=operators.pop();
									if(isAlpha(opr)==1){
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
							  if(isAlpha(opr)==1){
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
  
	
	
	void initializeButtons() {
		btn0=(Button) findViewById(R.id.btn0);
		btn1=(Button) findViewById(R.id.btn1);
		btn2=(Button) findViewById(R.id.btn2);
		btn3=(Button) findViewById(R.id.btn3);
		btn4=(Button) findViewById(R.id.btn4);
		btn5=(Button) findViewById(R.id.btn5);
		btn6=(Button) findViewById(R.id.btn6);
		btn7=(Button) findViewById(R.id.btn7);
		btn8=(Button) findViewById(R.id.btn8);
		btn9=(Button) findViewById(R.id.btn9);
		btndot=(Button) findViewById(R.id.btndot);
		btndiv=(Button) findViewById(R.id.btndiv);
		btnadd=(Button) findViewById(R.id.btnadd);
		btnsub=(Button) findViewById(R.id.btnsub);
		btnmult=(Button) findViewById(R.id.btnmult);
		btnres=(Button) findViewById(R.id.btnresult);
		t1=(EditText) findViewById(R.id.editText1);
		btnbrck1=(Button) findViewById(R.id.btnbrck1);
		btnbrck2=(Button) findViewById(R.id.btnbrck2);
		btnclear=(Button)findViewById(R.id.btnclear);
		btnres=(Button) findViewById(R.id.btnresult);
		btnback=(Button) findViewById(R.id.btnback);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.scientific) {
			Intent appInfo = new Intent(MainActivity.this, AdvancedActivity.class);
		       startActivity(appInfo);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
