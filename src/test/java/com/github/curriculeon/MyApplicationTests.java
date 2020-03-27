package com.github.curriculeon;

import com.neovisionaries.i18n.CountryCode;
import io.sphere.sdk.queries.QueryPredicate;
import io.sphere.sdk.zones.Zone;
import io.sphere.sdk.zones.queries.ZoneQueryModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {


	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println(new MyApplicationTests().getAllStates(CountryCode.US));
	}
//https://www.codota.com/code/java/methods/io.sphere.sdk.zones.Location/getState
	public List<String> getAllStates(CountryCode country) {
		QueryPredicate<Zone> s = ZoneQueryModel
				.of()
				.locations()
				.where(location -> location.country().is(country));
		return Arrays.asList(s.toSphereQuery());
	}

}
