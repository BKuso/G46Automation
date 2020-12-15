package models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.DbName;
import org.javalite.activejdbc.annotations.Table;

@DbName("study")
@Table("public.users")
public class User extends Model {

}
