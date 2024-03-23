scoreboard objectives add generation dummy
execute unless score FakePlayer generation matches 1 run function createskybound:generation
scoreboard players set FakePlayer generation 1