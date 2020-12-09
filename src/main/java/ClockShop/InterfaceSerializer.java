package ClockShop;

import Clock.ClockBrands;
import Clock.ClockType;
import Clock.IClock;
import Clock.Clock;
import Clock.ExtendedClock;
import com.google.gson.*;

import java.lang.reflect.Type;

class InterfaceSerializer implements JsonSerializer<IClock>, JsonDeserializer<IClock> {

    @Override
    public JsonElement serialize(IClock value, final Type type, final JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("hour", value.getHour());
        object.addProperty("minute", value.getMinute());
        object.addProperty("second", value.getSecond());
        object.addProperty("price", value.getPrice());
        object.addProperty("brand", String.valueOf(value.getBrand()));
        object.addProperty("type", String.valueOf(value.getType()));
        return object;
    }


    @Override
    public IClock deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        int hour = object.get("hour").getAsInt();
        int minute = object.get("minute").getAsInt();
        int second = object.get("second").getAsInt();
        int price = object.get("price").getAsInt();
        ClockBrands brand = ClockBrands.valueOf(object.get("brand").getAsString());
        ClockType kind = ClockType.valueOf(object.get("type").getAsString());
        if(kind == ClockType.DEFAULT){
            return new Clock(hour, minute, price, brand);
        }else if(kind == ClockType.EXTENDED){
            return new ExtendedClock(hour, minute, second, price, brand);
        }
        return null;
    }
}