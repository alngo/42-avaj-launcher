# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: alngo <alngo@student.42.fr>                +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2019/11/06 14:57:02 by alngo             #+#    #+#              #
#    Updated: 2020/03/02 13:52:32 by alngo            ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

NAME := avaj-launcher

.PHONY: clean build test watch

all: $(NAME)

$(NAME): build
	@echo "Build and run"
	java avaj.main.App public/scenarios/scenario.txt

build:
	find * -name "*.java" > sources.txt
	javac -sourcepath . @sources.txt

test: build
	java org.junit.runner.JUnitCore avaj.test.simulator.SimulatorTest
	java org.junit.runner.JUnitCore avaj.test.simulator.DocumentTest
	java org.junit.runner.JUnitCore avaj.test.simulator.WeatherTowerTest
	java org.junit.runner.JUnitCore avaj.test.simulator.TowerTest
	java org.junit.runner.JUnitCore avaj.test.weather.WeatherProviderTest
	java org.junit.runner.JUnitCore avaj.test.aircraft.CoordinatesTest

watch:
	watchmedo shell-command --pattern="**/*.java" --command="make test" -R -W

clean:
	$(RM) sources.txt
	$(RM) *.class
