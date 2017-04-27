package com.xjtu.entity;

public class ClassInfoByClass implements Comparable<ClassInfoByClass>{

	    //学期
	    private String term;
	    //班级名
	    private String classname;
	    //第几周
	    private String week;
	    //第几节
	    private String lesson;
	    //课程信息
	    private String info;

	    public String getTerm() {
	        return term;
	    }

	    public void setTerm(String term) {
	        this.term = term;
	    }
	    
		public String getClassname() {
			return classname;
		}

		public void setClassname(String classname) {
			this.classname = classname;
		}

		public String getWeek() {
	        return week;
	    }

	    public void setWeek(String week) {
	        this.week = week;
	    }

	    public String getLesson() {
	        return lesson;
	    }

	    public void setLesson(String lesson) {
	        this.lesson = lesson;
	    }

	    public String getInfo() {
	        return info;
	    }

	    public void setInfo(String info) {
	        this.info = info;
	    }


	    @Override
	    public int compareTo(ClassInfoByClass o) {
	        int w1=Integer.parseInt(this.week);
	        int w2=Integer.parseInt(o.getWeek());
	        //先按星期进行排列；
	        if(w1>w2){
	            return (w1-w2);
	        }
	        if (w1<w2){
	            return (w1-w2);
	        }
	        //按第几节课进行排序
	        int class1=Integer.parseInt(this.lesson);
	        int class2=Integer.parseInt(o.getLesson());
	        if (class1>class2){
	            return (class1-class2);
	        }
	        if (class1<class2){
	            return (class1-class2);
	        }
	        return  0;
	    }

		@Override
		public String toString() {
			return "ClassInfoByClass [term=" + term + ", classname=" + classname + ", week=" + week + ", lesson="
					+ lesson + ", info=" + info + "]";
		}

	    
	}

