ITISProxyLoader
=========

1 - Download ITIS SQLite3 export from http://www.itis.gov/downloads/index.html
    http://www.itis.gov/downloads/itisSqlite.zip

2 - Unzip files

3 - Open ITIS.sqlite and add the following indexes (this could happen in the code but not done yet):
```
   CREATE INDEX "jurisdiction_jurisdiction_index_tsn" ON "jurisdiction" ("tsn");
   CREATE INDEX "taxonomic_units_tsn_index" ON "taxonomic_units" ("tsn");
   CREATE INDEX "taxonomic_units_parent_tsn_index" ON "taxonomic_units" ("parent_tsn");
   CREATE INDEX "strippedauthor_author_id_index" ON "strippedauthor" ("taxon_author_id");
   CREATE INDEX "synonym_links_tsn_index" ON "synonym_links" ("tsn");
   CREATE INDEX "synonym_links_tsn_accepted_index" ON "synonym_links" ("tsn_accepted");
   CREATE INDEX "taxonomic_units_taxon_author_id_index" ON "taxonomic_units" ("taxon_author_id");
```

4 - Install http://code.google.com/p/sqlite4java
   These libraries (libsqlite_jni.la  libsqlite_jni.so in the version tested: sqlite4java-282.zip)
   need to be in the LD_LIBRARY_PATH and the JAR from this package, sqlite.jar 
   needs to be in the CLASSPATH

5 - Run the loader:
    java ca.gc.agr.mbb.itisproxyloader.ItisLoader absolute_location_of_ITIS_sqlite_db path_of_cache_dir


On my laptop it takes ~55 minutes to create Java BDB index directory of ~835MB

Notes:
- The Java BDB log files are larger than in the past: 128MB instead of 16MB, so there are less of them
- The SQL is queried in 4000 record chunks. Much larger than this and some memory leak caused an OOM error. Something wrong with the driver.


