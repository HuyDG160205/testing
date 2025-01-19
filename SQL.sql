select * from weather as this
where this.temperature >= (select temperature from weather
							where recorddate = (select ))

