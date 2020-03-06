BEGIN TRANSACTION;
DROP TABLE IF EXISTS "vehicles";
CREATE TABLE IF NOT EXISTS "vehicles" (
	"VIN"	TEXT NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"make"	TEXT NOT NULL,
	"model"	TEXT NOT NULL,
	"year"	INTEGER NOT NULL,
	"color"	TEXT NOT NULL,
	"trim"	TEXT,
	"engine"	TEXT NOT NULL,
	"notes"	TEXT,
	"owner"	TEXT NOT NULL,
	PRIMARY KEY("VIN")
);
DROP TABLE IF EXISTS "users";
CREATE TABLE IF NOT EXISTS "users" (
	"username"	TEXT NOT NULL UNIQUE,
	"firstName"	TEXT NOT NULL,
	"lastName"	TEXT NOT NULL,
	"hashedPassword"	TEXT NOT NULL,
	"securityQuestion"	TEXT NOT NULL,
	"hashedSecurityAnswer"	TEXT NOT NULL,
	PRIMARY KEY("username")
);
DROP TABLE IF EXISTS "trips";
CREATE TABLE IF NOT EXISTS "trips" (
	"tripID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"vehicleName"	TEXT NOT NULL,
	"owner"	TEXT NOT NULL,
	"dateBegin"	INTEGER NOT NULL,
	"dateEnd"	INTEGER NOT NULL,
	"placeBegin"	TEXT NOT NULL,
	"placeEnd"	TEXT NOT NULL,
	"milesBegin"	REAL NOT NULL,
	"milesEnd"	REAL NOT NULL,
	"cost"	REAL NOT NULL,
	"fuelEcon"	REAL NOT NULL,
	"notes"	TEXT
);
DROP TABLE IF EXISTS "records";
CREATE TABLE IF NOT EXISTS "records" (
	"ID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"vehicleVIN"	TEXT NOT NULL,
	"owner"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"date"	INTEGER NOT NULL,
	"miles"	REAL NOT NULL,
	"cost"	REAL,
	"location"	TEXT,
	"notes"	BLOB
);
COMMIT;
