package com.vinilearning.tangai.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class MyDataBase extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "bikiptangai";
	private static final int DATABASE_VERSION = 1;

	/** Category table. */
	public static final String CATEGORY_TABLE = "tblCategory";
	public static final String CATEGORY_ID = "id";
	public static final String CATEGORY_CONTENT = "content";

	/** DanhSach table. */
	public static final String CONTENT_TABLE = "tblDanhSach";
	public static final String CONTENT_ID = "_id";
	public static final String CONTENT_ITEM_ID = "itemId";
	public static final String CONTENT_PARENTID = "parentId";
	public static final String CONTENT_TEXT = "content";

	/** Favorites table. */
	public static final String FAVORITES_TABLE = "tblFavorites";
	public static final String FAVORITES_ID = "id";
	public static final String FAVORITES_ID_DANHSACH = "idDanhSach";

	private SQLiteDatabase db;

	private final String[] comlumnsContent = { CONTENT_ID, CONTENT_ITEM_ID,
			CONTENT_TEXT, CONTENT_PARENTID };

	public MyDataBase(Context paramContext) {
		super(paramContext, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Method used to get all CATEGORY.
	 * 
	 * @return
	 */
	public Cursor getAllCategoryFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		String[] arrayOfString = { CATEGORY_ID, CATEGORY_CONTENT };
		localSQLiteQueryBuilder.setTables(CATEGORY_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				arrayOfString, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	/**
	 * Method used to get all CATEGORY.
	 * 
	 * @return
	 */
	public Cursor getAllContentFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		localSQLiteQueryBuilder.setTables(CONTENT_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				comlumnsContent, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	/**
	 * Get all favorites in database.
	 * 
	 * @return
	 */
	public Cursor getAllFavoritesFromDb() {
		SQLiteDatabase localSqLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSqLiteQueryBuilder = new SQLiteQueryBuilder();
		localSqLiteQueryBuilder.setTables(FAVORITES_TABLE);
		String[] arrayOfString = { FAVORITES_ID, FAVORITES_ID_DANHSACH };
		Cursor localCursor = localSqLiteQueryBuilder.query(localSqLiteDatabase,
				arrayOfString, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	public void close() {
		if (db != null) {
			db.close();
		}
	}

	public void openWrite() {
		if (db == null) {
			db = getWritableDatabase();
		}
	}

}
