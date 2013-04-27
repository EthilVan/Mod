package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class EVServerUtils {

	private ServerData server;

	public EVServerUtils(ServerData par1ServerData) {
		try {
			server = getServerData(par1ServerData);
		} catch (IOException e) {
		}
	}

	private ServerData getServerData(ServerData par1ServerData) throws IOException {
		ServerAddress var1 = ServerAddress.func_78860_a(par1ServerData.serverIP);
		Socket var2 = null;
		DataInputStream var3 = null;
		DataOutputStream var4 = null;
		try {
			var2 = new Socket(var1.getIP(), var1.getPort());
			var2.setSoTimeout(3000);
			var2.setTcpNoDelay(true);
			var2.setTrafficClass(18);
			var3 = new DataInputStream(var2.getInputStream());
			var4 = new DataOutputStream(var2.getOutputStream());
			var4.write(254);
			var4.write(1);
			if (var3.read() != 255) {
				throw new IOException("Bad message");
			}
			String var5 = Packet.readString(var3, 256);
			char[] var6 = var5.toCharArray();
			for (int var7 = 0; var7 < var6.length; ++var7) {
				if (var6[var7] != 167 && var6[var7] != 0 && ChatAllowedCharacters.allowedCharacters.indexOf(var6[var7]) < 0) {
					var6[var7] = 63;
				}
			}
			var5 = new String(var6);
			int var8;
			int var9;
			String[] var26;
			if (var5.startsWith("\u00a7") && var5.length() > 1) {
				var26 = var5.substring(1).split("\u0000");

				if (MathHelper.parseIntWithDefault(var26[0], 0) == 1) {
					par1ServerData.serverMOTD = var26[3];
					par1ServerData.field_82821_f = MathHelper.parseIntWithDefault(var26[1], par1ServerData.field_82821_f);
					par1ServerData.gameVersion = var26[2];
					var8 = MathHelper.parseIntWithDefault(var26[4], 0);
					var9 = MathHelper.parseIntWithDefault(var26[5], 0);

					if (var8 >= 0 && var9 >= 0) {
						par1ServerData.populationInfo = var8 + "/" + var9;
					} else {
						par1ServerData.populationInfo = "" + "???";
					}
				} else {
					par1ServerData.gameVersion = "???";
					par1ServerData.serverMOTD = "" + "???";
					par1ServerData.field_82821_f = 61;
					par1ServerData.populationInfo = "" + "???";
				}
			} else {
				var26 = var5.split("\u00a7");
				var5 = var26[0];
				var8 = -1;
				var9 = -1;
				try {
					var8 = Integer.parseInt(var26[1]);
					var9 = Integer.parseInt(var26[2]);
				} catch (Exception var24) {
					;
				}
				par1ServerData.serverMOTD = var5;
				if (var8 >= 0 && var9 > 0) {
					par1ServerData.populationInfo = var8 + "/" + var9;
				} else {
					par1ServerData.populationInfo = "" + "???";
				}
				par1ServerData.gameVersion = "1.3";
				par1ServerData.field_82821_f = 59;
			}
		} catch (Exception e) {
			if (var3 != null) {
				var3.close();
			}
			if (var4 != null) {
				var4.close();
			}
			if (var2 != null) {
				var2.close();
			}
			par1ServerData.serverIP = "???";
			par1ServerData.gameVersion = "???";
			par1ServerData.serverMOTD = "???";
			par1ServerData.populationInfo =  "???";
			return par1ServerData;
		}
		return par1ServerData;
	}


	public String getIp() {
		return server.serverIP;
	}

	public String getMOTD() {
		return server.serverMOTD;
	}

	public String getServerName() {
		return server.serverName;
	}

	public String getPopulationInfo() {
		return server.populationInfo;
	}

	public String getMinecraftVersion() {
		return server.gameVersion;
	}

	public void update(ServerData par1ServerData) {
		try {
			server = getServerData(par1ServerData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
