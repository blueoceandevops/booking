mvn clean
mvn package -Dmaven.test.skip=true

scp ./target/booking-0.0.1-SNAPSHOT.jar root@47.106.164.204:/home/admin/booking-0.0.1-SNAPSHOT.jar

scp booking.sql root@47.106.164.204:/home/admin/booking.sql