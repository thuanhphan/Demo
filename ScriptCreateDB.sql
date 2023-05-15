CREATE TABLE "user"(email VARCHAR(255) PRIMARY KEY NOT NULL);
CREATE TABLE friend(id bigserial PRIMARY KEY, person1 text, person2 text,
				   FOREIGN KEY(person1) REFERENCES "user"(email),
				   FOREIGN KEY(person2) REFERENCES "user"(email));
				   
INSERT INTO "user"(email) VALUES('kim@gmail.com');
INSERT INTO "user"(email) VALUES('stephanie@gmail.com');
INSERT INTO "user"(email) VALUES('geogre@gmail.com');
INSERT INTO "user"(email) VALUES('chris@gmail.com');
INSERT INTO "user"(email) VALUES('jennifer@gmail.com');
INSERT INTO "user"(email) VALUES('james@gmail.com');

INSERT INTO friend(person1, person2) VALUES('kim@gmail.com', 'stephanie@gmail.com');
INSERT INTO friend(person1, person2) VALUES('geogre@gmail.com', 'chris@gmail.com');

CREATE TABLE subscription(id bigserial PRIMARY KEY, requester text, target text,
				   FOREIGN KEY(requester) REFERENCES "user"(email),
				   FOREIGN KEY(target) REFERENCES "user"(email));
				   
CREATE TABLE block(id bigserial PRIMARY KEY, blocker text, blockee text,
				   FOREIGN KEY(blocker) REFERENCES "user"(email),
				   FOREIGN KEY(blockee) REFERENCES "user"(email));
