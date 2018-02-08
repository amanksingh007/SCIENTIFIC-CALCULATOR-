package com.example.calci2;
import java.util.Stack;

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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AdvancedActivity extends Activity {
	private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btndot;
	private Button btnsqrt,btnsqr,btnpow,btnexpp,btnln,btnlog,btnfact,btnmod,btnmodfun,btnexp;
	private Button btnadd,btnsub,btnmult,btndiv;
	private Button btnclear,btnbrck1,btnbrck2,btnback,btnresult;
	private Button btnsin,btncos,btntan,btnasin,btnacos,btnatan,btnsinh,btncosh,btntanh;
	private Button btnpi,btne;
	private EditText t1; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_advanced);
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
		
		btnsqrt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" \u221A(");
			}
		});
		
		btnexp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" e ^ ");
			}
		});

		btnfact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" ! ");
			}
		});
		
		btnsin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" sin( ");
			}
		});		

		btncos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" cos( ");
			}
		});
		btntan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" tan( ");
			}
		});
		btnatan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" atan( ");
			}
		});
		
		btnasin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" asin( ");
			}
		});
		
		btnacos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" acos( ");
			}
		});
		btnsinh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" sinh( ");
			}
		});
		
		btncosh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" cosh( ");
			}
		});
		
		btntanh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" tanh( ");
			}
		});
		
		btnpow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" ^ ");
			}
		});
		
		btnln.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" ln( ");
			}
		});
		
		btnlog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" log( ");
			}
		});
		
		btnpi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" \u03C0 ");
			}
		});
		
		btne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" e ");
			}
		});
		
		btnsqr.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t1.setText(" "+t1.getText().toString().trim()+" ^ 2");
			}
		});

		btnresult.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuilder expression=new StringBuilder(1000);
				String exp=(t1.getText()).toString();
				expression.append(exp);
				String str=modify(expression.toString());
				double ans=evaluate(str);
				if(ans!=-123456789){
				        t1.setText(""+ans);
				    }
				else
				t1.setText("INVALID EXPRESSION");
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
			 exp=exp.replaceAll("\u221A","sqrt");
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
	         exp=exp.replaceAll("\u03C0","3.141592654");
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
			     t1.setText("INVALID EXPRESSION");
			      return(-123456789);
		      }
			
			return stack.pop();
		
		}
 
	
	
	
	
	void initializeButtons() {
		btn0=(Button) findViewById(R.id.btnzero);
		btn1=(Button) findViewById(R.id.btnone);
		btn2=(Button) findViewById(R.id.btntwo);
		btn3=(Button) findViewById(R.id.btnthree);
		btn4=(Button) findViewById(R.id.btnfour);
		btn5=(Button) findViewById(R.id.btnfive);
		btn6=(Button) findViewById(R.id.btnsix);
		btn7=(Button) findViewById(R.id.btnseven);
		btn8=(Button) findViewById(R.id.btneight);
		btn9=(Button) findViewById(R.id.btnnine);
		btndot=(Button) findViewById(R.id.btndecimal);
		btndiv=(Button) findViewById(R.id.btndivide);
		btnadd=(Button) findViewById(R.id.btnsum);
		btnsub=(Button) findViewById(R.id.btnminus);
		btnmult=(Button) findViewById(R.id.btnmultiply);
		t1=(EditText) findViewById(R.id.editText);
		btnbrck1=(Button) findViewById(R.id.btnbracket1);
		btnbrck2=(Button) findViewById(R.id.btnbracket2);
		btnclear=(Button)findViewById(R.id.btncls);
		btnsqrt=(Button) findViewById(R.id.btnsqrt);
		btnresult=(Button) findViewById(R.id.btnres);
		btnback=(Button) findViewById(R.id.btnbck);
		btnpow=(Button) findViewById(R.id.btnpower);
		btnexp=(Button) findViewById(R.id.btnexpp);
		btnsin=(Button) findViewById(R.id.btnsin);
		btncos=(Button) findViewById(R.id.btncos);
		btntan=(Button) findViewById(R.id.btntan);
		btnasin=(Button) findViewById(R.id.btnasin);
		btnacos=(Button) findViewById(R.id.btnacos);
		btnatan=(Button) findViewById(R.id.btnatan);
		btnsinh=(Button) findViewById(R.id.btnsinh);
		btncosh=(Button) findViewById(R.id.btncosh);
		btntanh=(Button) findViewById(R.id.btntanh);
		btnsqr=(Button) findViewById(R.id.btnsqr);
		btnfact=(Button) findViewById(R.id.btnfact);
		btnmod=(Button) findViewById(R.id.btnmod);
		btnmodfun=(Button) findViewById(R.id.btnmodfun);
		btnpi=(Button) findViewById(R.id.btnpi);
		btne=(Button) findViewById(R.id.btne);
		btnln=(Button) findViewById(R.id.btnlne);
		btnlog=(Button) findViewById(R.id.btnlog10);
		//t1=(EditText) findViewById(R.id.editText)
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.advanced, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.simple) {
			Intent appInfo = new Intent(AdvancedActivity.this,MainActivity.class);
		       startActivity(appInfo);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
