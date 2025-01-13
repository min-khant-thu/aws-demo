import json


NAME = 'Yamada Tarou'

def lambda_handler(event, context):
    try:
        name = event.get('name', None)

        if name:
            return {
                "nameExists": name == NAME
            }
        else:
            return {
                "nameExists": False
            }
    except Exception as e:
        print(f"An error occured: {e}")
        return {
            "nameExists": False
        }
