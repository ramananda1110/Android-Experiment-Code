package com.database.helper;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SongInPlayListTable {
	public static final String SONG_IN_PLAYLIST_TABLE_NAME = "song_in_playlist";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_SONG_ID = "song_id";
	public static final String COLUMN_PLAYLIST_ID = "playlist_id";

	// Database creation SQL statement
	private static final String CREATE_SONG_IN_PLAYLIST_TABLE = "CREATE TABLE IF NOT EXISTS"
			+ SONG_IN_PLAYLIST_TABLE_NAME
			+ "("
			+ COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUMN_SONG_ID
			+ " INTEGER," + COLUMN_PLAYLIST_ID + " INTEGER" + ");";

	public static void onCreateTable(SQLiteDatabase database) {
		database.execSQL(CREATE_SONG_IN_PLAYLIST_TABLE);
	}

	public static void onUpgradeTable(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(SongInPlayListTable.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + SONG_IN_PLAYLIST_TABLE_NAME);
		onCreateTable(database);
	}

}
