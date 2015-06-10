/**
 * IK 中文分词  版本 5.0.1
 * IK Analyzer release 5.0.1
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 * 
 * 
 */
package org.wltea.analyzer.sample;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 使用IKAnalyzer进行分词的演示
 * 2012-10-22
 *
 */
public class IKAnalzyerDemo {
	
	public static void main(String[] args){
		//构建IK分词器，使用smart分词模式
		Analyzer analyzer = new IKAnalyzer(false);
		
		//获取Lucene的TokenStream对象
	    TokenStream ts = null;
		try {
			//ts = analyzer.tokenStream("myfield", new StringReader("在2014年的暑假，中大共有620名學生參加了由學生事務處舉辦的「寰宇暑期實習計劃」，實習地點遍佈世界各地，國家數目由去年的24個增加至41個，增幅達七成。新增的實習國家地點包括東歐的立陶宛、保加利亞，中亞的哈薩克、吉爾吉斯，東南亞的尼泊爾、柬埔寨，非洲的塞內加爾、尚比亞，以及南美的智利等。 「寰宇暑期實習計劃」自1997年展開，為學生提供多元化的實習經驗及文化交流機會，至今已惠及超過4,300名學生。有見近年亞太地區的經濟發展蓬勃，學生事務處積極拓展亞太區的實習機會。透過不同機構夥伴的支持，今年共有多達100名學生前往亞太地區實習，人數比去年增加了五成。"));
//			ts = analyzer.tokenStream("myfield", new StringReader("这是一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too"));
			ts = analyzer.tokenStream("myfield", new StringReader("apple's and its' book, BigData"));
			//ts = analyzer.tokenStream("myfield", new StringReader("李彦宏毕业于北京大学信息管理专业，随后前往美国布法罗纽约州立大学完成计算机科学硕士学位，先后担任道·琼斯公司高级顾问、《华尔街日报》网络版实时金融信息系统设计者"));
//			ts = analyzer.tokenStream("myfield", new StringReader("香港中文大学"));
			//获取词元位置属性
		    OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class); 
		    //获取词元文本属性
		    CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
		    //获取词元文本属性
		    TypeAttribute type = ts.addAttribute(TypeAttribute.class);
		    
		    
		    //重置TokenStream（重置StringReader）
			ts.reset(); 
			//迭代获取分词结果
			while (ts.incrementToken()) {
			  System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
			}
			//关闭TokenStream（关闭StringReader）
			ts.end();   // Perform end-of-stream operations, e.g. set the final offset.

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//释放TokenStream的所有资源
			if(ts != null){
		      try {
				ts.close();
		      } catch (IOException e) {
				e.printStackTrace();
		      }
			}
	    }
		
	}

}
