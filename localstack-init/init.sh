#!/bin/bash

# Queue情報
QUEUE_NAME="customer-info-queue"
ENDPOINT_URL="http://localhost:4566"
QUEUE_URL=""
MESSAGE_BODY='{
  "name": "山田 太郎",
  "address": "東京都足立区1-1-1",
  "age": 30,
  "join_date": "2024-01-01",
  "gender": "Male",
  "occupation": "Software Engineer"
}'

# queue作成
echo "作成中: $QUEUE_NAME..."
QUEUE_URL=$(aws --endpoint-url=$ENDPOINT_URL sqs create-queue --queue-name $QUEUE_NAME --query 'QueueUrl' --output text)

if [ $? -eq 0 ]; then
  echo "'$QUEUE_NAME' の作成に完了しました。"
  echo "Queue URL: $QUEUE_URL"
  
  # データ登録
  echo "初期データ登録中。　。　。"
  aws --endpoint-url=$ENDPOINT_URL sqs send-message --queue-url $QUEUE_URL --message-body "$MESSAGE_BODY"
  
  if [ $? -eq 0 ]; then
    echo "初期データ登録完了しました。"
  else
    echo "初期データ登録に失敗しました。"
  fi
else
  echo "'$QUEUE_NAME'の作成に失敗しました。"
fi
