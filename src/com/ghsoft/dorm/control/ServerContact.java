package com.ghsoft.dorm.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerContact {

	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	String data = null;

	public ServerContact(String data) throws IOException {
		this.data = data;
	}

	public String connect() throws IOException {

		try {
			socket = new Socket("example.com", 4466);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			out.println(data);
			String data = in.readLine();
			if (!data.equals("")) {
				System.out.println("message receved");
				out.close();
				in.close();
				socket.close();
				return data;
			} else {
				System.out.println("message failure");
				out.close();
				in.close();
				socket.close();
				return "false";
			}

		} catch (UnknownHostException e) {
			System.err.println("cannot connect to host.");
			return "no response from host, do you have a data connection? server may be down";
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the host");
			return "no response from host, do you have a data connection? server may be down";
		}

	}

}
