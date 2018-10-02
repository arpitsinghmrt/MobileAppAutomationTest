curl --user ${CIRCLE_TOKEN}: \
    --request POST \
    --form revision=25d483d25a1113f6f0e21bbd6f39ff6deefdbda8\
    --form config=@config.yml \
    --form notify=false \
        https://circleci.com/api/v1.1/project/github/arpitsinghmrt/MobileAppAutomationTest/tree/master
