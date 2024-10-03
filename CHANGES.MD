Made changes specifically to Cipher.java in order to handle the tests better.
Also good to note, many of my previous tests failed because-
-I did System.err.print(); but the tests wants System.err.print("Error: blahblahbladh);
So code related changes, are in Cipher to those err calls and then one if statement.
