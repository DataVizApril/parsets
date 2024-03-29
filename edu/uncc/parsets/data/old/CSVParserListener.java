package edu.uncc.parsets.data.old;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * Copyright (c) 2009, Robert Kosara, Caroline Ziemkiewicz,
 *                     and others (see Authors.txt for full list)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the name of UNC Charlotte nor the names of its contributors
 *      may be used to endorse or promote products derived from this software
 *      without specific prior written permission.
 *      
 * THIS SOFTWARE IS PROVIDED BY ITS AUTHORS ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
\* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public interface CSVParserListener {

	/**
	 * Called at the end of {@link CSVParser#analyzeCSVFile()}.
	 * 
	 * @param data The dataset, containing dimensions with metadata (if any)
	 * and category definitions and stats.
	 */
	public void setDataSet(CSVDataSet data);
	
	/**
	 * Will be called with values from 0 to 100 during parsing. If length of
	 * file is unknown, will be called with value of -1.
	 * 
	 * @param progress Parsing progress from 0 to 100 or -1
	 */
	public void setProgress(int progress);
	
	/**
	 * Called when the complete import is done.
	 */
	public void importDone();
	
	/**
	 * Called when the parser can't open the file.
	 * 
	 * @param filename
	 */
	public void errorFileNotFound(String filename);
	
	/**
	 * Called when the parser encounters an IOError or other problem while
	 * reading the file.
	 * 
	 * @param filename The name of the file being read.
	 */
	public void errorReadingFile(String filename);
	
	/**
	 * Called when the parser encounters a line with the wrong number of
	 * columns while analyzing the CSV file. At that point, the parser
	 * aborts the analysis and goes into an undefined state. Trying
	 * to continue the import will lead to a program crash.
	 * 
	 * @param expected The number of columns the parser expected
	 * @param found The number of columns found
	 * @param line The line the error happened
	 */
	public void errorWrongNumberOfColumns(int expected, int found, int line);

	
}
