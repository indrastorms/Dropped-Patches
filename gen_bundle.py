import requests
import json


def get_latest_release(repo_url):
    api_url = f"{repo_url}/releases/latest"
    response = requests.get(api_url)
    if response.status_code == 200:
        data = response.json()
        version = data["tag_name"]
        asset_url = data["assets"][0]["browser_download_url"]
        return version, asset_url
    else:
        return None, None


def main():
    patches_repo = "https://api.github.com/repos/indrastorms/Dropped-Patches"
    integration_repo = "https://api.github.com/repos/revanced/revanced-integrations"

    patches_version, patches_asset_url = get_latest_release(patches_repo)
    integration_version, integration_asset_url = get_latest_release(integration_repo)

    info_dict = {
        "patches": {"version": patches_version, "url": patches_asset_url},
        "integrations": {"version": integration_version, "url": integration_asset_url},
    }
    bundle_name = "dropped-patches-bundle.json"
    with open(bundle_name, "w") as file:
        json.dump(info_dict, file, indent=2)
    print(f"Latest release information saved to {bundle_name}")


if __name__ == "__main__":
    main()
